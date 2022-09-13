package com.example.foodapp.database

import com.example.foodator.Activity.Domain.FoodDomain

object UserStorage {
    var list : List<FoodDomain>?=null
    var email : String?=null
    var username : String?=null
}

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