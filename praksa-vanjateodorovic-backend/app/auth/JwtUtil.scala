package auth

import daos.UserDAO
import dtos.LoggedUserDTO
import models.User
import pdi.jwt.{Jwt, JwtAlgorithm, JwtBase64, JwtClaim, JwtHeader}
import pdi.jwt.algorithms.JwtHmacAlgorithm

import java.time.Instant
import java.util.Date
import javax.inject.Inject
import scala.concurrent.Future
import scala.util.Try

case class JwtUtil @Inject()(userDAO: UserDAO) {

}
  object JwtUtil {

    def createToken(loggedUserDTO: LoggedUserDTO): String = {

      val algorithm: JwtHmacAlgorithm = JwtAlgorithm.HS256
      val header = JwtHeader(algorithm, "JWT")
      val claims = JwtClaim(subject = Some(loggedUserDTO.email), expiration = Some(Date.from(Instant.now().plusSeconds(36000)).getTime))
//      val claims = claim
      val key: String = "secretKey"

      Jwt.encode(header, claims, key)
    }

    def isValidToken(jwtToken: String): Boolean = {
      Jwt.isValid(jwtToken, "secretKey", Seq(JwtAlgorithm.HS256))
    }

    def decodeToken(jwtToken: String): Try[JwtClaim] = {
      Jwt.decode(jwtToken, "secretKey", Seq(JwtAlgorithm.HS256))
    }

  }

