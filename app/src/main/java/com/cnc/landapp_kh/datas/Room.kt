package com.cnc.landapp_kh.datas

import java.text.DecimalFormat
import java.util.Locale

class Room(val price:Int,
           val address: String,
           val floor: Int,
           val description: String) {

    fun getFormattedFloor() : String{
        if(this.floor >= 1 ){
            return "${this.floor}층"
        }else if(this.floor == 0){
            return "반지하"
        }else{
            return "지하 ${-this.floor}층"
        }
    }

    fun getFormattedPrice() : String{
        if(this.price >= 10000){
            val uk = this.price / 10000 //정수끼리 나누면 몫만 남는다.
            val rest = this.price % 10000

            val myFormatter = DecimalFormat("###,###")

            return "${uk}억 ${myFormatter.format(rest)}"
        }else{

            val myFormatter = DecimalFormat("###,###")

            return "${myFormatter.format(this.price)}"
        }
    }
}