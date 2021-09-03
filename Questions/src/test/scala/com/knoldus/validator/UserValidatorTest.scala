package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.{Company, User}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class UserValidatorTest extends AnyFlatSpec {

  val parasUser: User = User("Paras","Jain",22,"Google","parasjain@knoldus.in")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmailvalidator = mock[EmailValidator]

  val userValidator = new UserValidator(mockedCompanyReadDto,mockedEmailvalidator)

  "User" should "be valid" in {

    when(mockedCompanyReadDto.getCompanyByName(parasUser.companyName)) thenReturn(Option(knoldusCompany))
    when(mockedEmailvalidator.emailIdIsValid(parasUser.emailId)) thenReturn(true)

    val result = userValidator.userIsValid(parasUser)
    assert(result)
  }

  "User" should "be invalid because his email is not valid" in {

    when(mockedCompanyReadDto.getCompanyByName(parasUser.companyName)) thenReturn(Option(knoldusCompany))
    when(mockedEmailvalidator.emailIdIsValid(parasUser.emailId)) thenReturn(false)

    val result = userValidator.userIsValid(parasUser)
    assert(!result)
  }

  "User" should "be invalid because his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(parasUser.companyName)) thenReturn(None)
    when(mockedEmailvalidator.emailIdIsValid(parasUser.emailId)) thenReturn(true)

    val result = userValidator.userIsValid(parasUser)
    assert(!result)
  }

  "User" should "be invalid because his email id is not valid and his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(parasUser.companyName)) thenReturn(None)
    when(mockedEmailvalidator.emailIdIsValid(parasUser.emailId)) thenReturn(false)

    val result = userValidator.userIsValid(parasUser)
    assert(!result)
  }

}
