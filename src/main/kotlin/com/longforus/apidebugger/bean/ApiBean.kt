package com.longforus.apidebugger.bean

import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

/**
 * Created by XQ Yang on 8/30/2018  5:41 PM.
 * Description :
 */
@Entity
data class ApiBean(@Id
var id: Long = 0,
    var method: Int = 0,
    @Index
    var url: String = "",
    @Convert(converter = MapDbConverter::class,
        dbType = String::class)
    var parameMap: Map<String, String> = mapOf(),
    var encryptType: Int = 0,var projectId:Long = 0): kotlin.Cloneable {

    constructor(url: String,projectId: Long) : this() {
        this.url = url
        this.projectId = projectId
    }



    override fun toString(): String {
        return url
    }


    public override fun clone(): Any {
        val map = mutableMapOf<String,String>()
        parameMap.forEach { t, u ->
            map[t] = u
        }
        return ApiBean(method = this.method,url = this.url+"新",parameMap = map,encryptType = this.encryptType,projectId = this.projectId)
    }



}