package fanjie.com.takeout.model

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/29 11:34
 * Notes:
 */
data class User(
    val balance: Double,
    val discount: Int,
    val id: Int,
    val integral: Int,
    val name: String,
    val phone: String
)