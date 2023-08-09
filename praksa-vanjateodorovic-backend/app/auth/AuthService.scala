package auth

import daos.UserDAO

import javax.inject.Inject
import pdi.jwt.{JwtAlgorithm, JwtClaim, JwtJson}
import play.api.Configuration

import scala.util.{Failure, Success, Try}


class AuthService @Inject()(config: Configuration
                           ) {

  def validateJwt(token: String): Try[JwtClaim] = for {
    claims <- JwtJson.decode(token, "secretKey", Seq(JwtAlgorithm.HS256)) // Decode the token using the secret key

    _ <- validateClaims(claims, token)     // validate the data stored inside the token
  } yield claims

  // Validates the claims inside the token. 'isValid' checks the issuedAt, expiresAt,
  // issuer and audience fields.

  private val validateClaims = (claims: JwtClaim, token: String) =>
    if (JwtUtil.isValidToken(token)) {
      Success(claims)
    } else {
      Failure(new Exception("The JWT did not pass validation"))
    }

}
