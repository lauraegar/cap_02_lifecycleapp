package uk.co.massimocarli.lifecycleapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


open class MainActivity : AppCompatActivity() {

  companion object {
    const val TAG = "ACTIVITY LIFECYCLE"
  }

  open protected val name = "ACTIVITY A"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    Log.d(TAG, "$name ON_CREATE")
    launchButton.setOnClickListener {
      launchSecondActivity()
    }
    launchPing.setOnClickListener {
      launchImplicit()
    }
    launchPicture.setOnClickListener {
      showPicture()
    }
  }

  private fun launchImplicit() {
    val intent = Intent().apply {
      action = "uk.co.massimocarli.pongapp.action.PING"
    }
    if (intent.resolveActivity(packageManager) != null) {
      startActivity(intent)
    } else {
      Toast.makeText(
        this,
        "No Pong Available",
        Toast.LENGTH_SHORT
      ).show()
    }
    getIntent()
  }


  private fun showPicture() {
    val intent = Intent().apply {
      action = Intent.ACTION_VIEW
      // This is the Uri per the single picture
      //data = Uri.parse("content://media/external/images/media/41")
      type = "image/*"
      // This is the Uri for the list of pictures
      //data = Uri.parse("content://media/external/images/media")
    }
    if (intent.resolveActivity(packageManager) != null) {
      startActivity(intent)
    } else {
      Toast.makeText(
        this,
        "No Photo Available",
        Toast.LENGTH_SHORT
      ).show()
    }
  }


//  fun pushMe(button: View) {
//    launchSecondActivity()
//  }

  private fun launchSecondActivity() {
    // Example with parameters
    /*
    val intent = Intent(
      this,
      SecondActivity::class.java
    ).apply {
      putExtra(Extras.EXTRA_FIRSTNAME, "Mickey")
      putExtra(Extras.EXTRA_LASTNAME, "Mouse")
      putExtra(Extras.EXTRA_AGE, 60)
    }
    */
    // Example with Serializable
    /*
    val intent = Intent(
      this,
      SecondActivity::class.java
    ).apply {
      putExtra(
        Extras.EXTRA_MOUSE,
        Mouse("Mickey", "Mouse", 60)
      )
    }
    */
    // Example with Parcelizable
    val intent = Intent(
      this,
      SecondActivity::class.java
    ).apply {
      putExtra(
        Extras.EXTRA_MOUSE,
        ParcelableMouse("Mickey", "Mouse", 60)
      )
    }
    startActivity(intent)
  }

  override fun onStart() {
    super.onStart()
    Log.d(TAG, "$name ON_START")
  }

  override fun onResume() {
    super.onResume()
    Log.d(TAG, "$name ON_RESUME")
  }

  override fun onRestart() {
    super.onRestart()
    Log.d(TAG, "$name ON_RESTART")
  }

  override fun onPause() {
    super.onPause()
    Log.d(TAG, "$name ON_PAUSE")
  }

  override fun onStop() {
    super.onStop()
    Log.d(TAG, "$name ON_STOP")
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.d(TAG, "$name ON_DESTROY")
  }

}
