package uk.co.massimocarli.lifecycleapp

import java.io.Serializable

data class Mouse(
  val firstName: String,
  val lastName: String,
  val age: Int
) : Serializable
