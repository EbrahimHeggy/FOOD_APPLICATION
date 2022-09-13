package com.ntgclarity.authenticator.database

import androidx.room.*
import com.example.foodator.Activity.Domain.FoodDomain

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo(name = "con_password") val con_password: String?,
    val list: List<FoodDomain>?

)

@Dao
interface UserDao {
    @Query("select * From user")
    fun getAllUsers(): List<User>

    @Insert
    fun insertUser(user: User)

    @Query("select * From user WHERE :e==email AND :p==password")
    fun getUser(e:String?,p: String?):List<User>
}
@Database(entities = [User::class], version = 1)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}


//Registration
//Request
//POST /register
//{
//    "name": "Abc Abc",
//    "email": "abc@gmail.com",
//    "password": "abc-pass"
//}
//Response
//200 OK
//Login
//POST /login
//{
//    "email": "abc@gmail.com",
//    "password": "abc-pass"
//}
//Response
//{
//    "name": "Abc Abc",
//    "email": "abc@gmail.com",
//    "token": "abc_token"
//}
//Products
//Request
//GET /products?category=coffee&token=abc_token
//Response
//[{
//    "id": 10,
//    "name": "Black coffee",
//    "price": 20.5,
//    "image": "https://picsum.photos/200",
//    "size": 1,
//    "sugar": 2,
//    "description": "Best black coffee",
//    "is_added_to_cart": false,
//    "category": "coffee",
//    "bought_items_count": 2,
//    "color": "000000"
//}]
//Profile
//PUT /profile
//{
//    "name": "Abc Abc",
//    "email": "abc@gmail.com",
//    "password": "abc-pass"
//}
//Response
//200 OK
