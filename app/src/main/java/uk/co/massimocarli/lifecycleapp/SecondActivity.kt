package uk.co.massimocarli.lifecycleapp

import android.os.Bundle
import android.widget.Toast

class SecondActivity : MainActivity() {

  override val name = "ACTIVITY B"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_second)
    //showIntentParameters()
    //showIntentParametersWithSerializable()
    showIntentParametersWithParcelable()
  }

  private fun showIntentParameters() {
    intent?.apply {
      val firstName = getStringExtra(Extras.EXTRA_FIRSTNAME)
      val lastName = getStringExtra(Extras.EXTRA_LASTNAME)
      val age = getIntExtra(Extras.EXTRA_AGE, 0)
      Toast.makeText(
        this@SecondActivity,
        "$firstName $lastName $age years old",
        Toast.LENGTH_SHORT
      ).show()
    }
  }

  private fun showIntentParametersWithSerializable() {
    intent?.apply {
      val mouse = getSerializableExtra(Extras.EXTRA_MOUSE) as Mouse
      Toast.makeText(
        this@SecondActivity,
        "${mouse.firstName} ${mouse.lastName} ${mouse.age} years old",
        Toast.LENGTH_SHORT
      ).show()
    }
  }

  private fun showIntentParametersWithParcelable() {
    intent?.apply {
      val mouse = getParcelableExtra(Extras.EXTRA_MOUSE) as ParcelableMouse
      Toast.makeText(
        this@SecondActivity,
        "${mouse.firstName} ${mouse.lastName} ${mouse.age} years old",
        Toast.LENGTH_SHORT
      ).show()
    }
  }
}