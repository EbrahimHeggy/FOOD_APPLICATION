package com.example.foodapp.database

object UserStorage {
    var token : String?=null
    var email : String?=null
    var username : String?=null
}

//package com.example.finalproject
//
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.finalproject.loginClasses.LoginResponse
//import com.example.finalproject.loginClasses.User
//import com.example.finalproject.sharedpref.SharedPre
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class MainActivity : AppCompatActivity(){
//    lateinit var Email : EditText
//    lateinit var Password : EditText
//    lateinit var Login : Button
//    lateinit var Register : TextView
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        SharedPre.sharedPre = applicationContext.getSharedPreferences("myPref",MODE_PRIVATE)
//
//        Login = findViewById(R.id.btn_login)
//        Register = findViewById(R.id.register)
//        Email = findViewById(R.id.et_email)
//        Password = findViewById(R.id.et_password)
//
//        Login.setOnClickListener{
//
//            // start user profile activity
//
//            if(Email.text.toString()!="" && Password.text.toString()!="")
//            {
//                val newUser = User (Email.text.toString(),Password.text.toString())
//                service.login(newUser)?.enqueue(object : Callback<LoginResponse>{
//
//                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                        if(response.isSuccessful)
//                        {
//                            SharedPre.setText(response.body()?.token.toString())
//                            checkToken()
//                        }
//                        else {
//                            Toast.makeText(applicationContext,"Invalid Username or Password",Toast.LENGTH_SHORT).show()
//
//                        }
//                    }
//
//                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                        Log.d("###", "Nothing")
//                    }
//                })
//            }
//            else{
//                Toast.makeText(this,"Please Fill All Required Fields",Toast.LENGTH_SHORT).show()
//            }
//        }
//        Register.setOnClickListener{
//            startActivity(Intent(this,RegisterActivity::class.java))
//        }
//        checkToken()
//    }
//
//    fun checkToken()
//    {
//        if(SharedPre.getText()!="")
//        {
//            val intent = Intent(this, ProductListActivity::class.java)
//            intent.flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//            startActivity(intent)
//        }
//    }
//}
//
data class Menu(val name:String, val uniqueId:String, val sugar:String){
    val dataBaseV :LocalStorage= DataBaseRoomImpl()

}
val dataBaseV :LocalStorage= LocalStorageImpl()
fun tryV2() {
    val dataBaseV :LocalStorage= LocalStorageImpl()
    dataBaseV.getAllMenus()
}
interface LocalStorage {
    fun save(menus :ArrayList<Menu>)
    fun getAllMenus():ArrayList<Menu>?
    fun add(id:String,menu :Menu)
    fun replace(id:String,menu :Menu)
    fun get(id:String)
}
//Static
object MyMenu {
    var menus :ArrayList<Menu>? = null
}

class LocalStorageImpl : LocalStorage {
    override fun save(menus: ArrayList<Menu>) {
        MyMenu.menus = menus

    }
    override fun getAllMenus(): ArrayList<Menu>? {
        return MyMenu.menus
    }
    override fun add(
        id: String,
        menu: Menu
    ) {
        MyMenu.menus?.add(menu)
    }
    override fun replace(
        id: String,
        menu: Menu
    ) {
        val oldMenu = MyMenu.menus?.find { it.uniqueId == id }
        MyMenu.menus?.remove(oldMenu)
        MyMenu.menus?.add(menu)
    }
    override fun get(id: String) {
        MyMenu.menus?.filter { it.uniqueId == id }
    }
}
//
class DataBaseRoomImpl :LocalStorage {

    override fun save(menus: ArrayList<Menu>) {
        TODO("Not yet implemented")
    }
    override fun getAllMenus(): ArrayList<Menu> {
        TODO("Not yet implemented")
    }
    override fun add(
        id: String,
        menu: Menu
    ) {
        TODO("Not yet implemented")
    }
    override fun replace(
        id: String,
        menu: Menu
    ) {
        TODO("Not yet implemented")
    }
    override fun get(id: String) {
        TODO("Not yet implemented")
    }
}
//Room Data base