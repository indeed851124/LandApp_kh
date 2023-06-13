package com.cnc.landapp_kh

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.cnc.landapp_kh.databinding.ActivityMainBinding
import com.cnc.landapp_kh.databinding.ActivityViewRoomDetailBinding
import com.cnc.landapp_kh.datas.Room

class ViewRoomDetailActivity : AppCompatActivity() {
    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityViewRoomDetailBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 기존 setContentView 를 제거해주시고..
//        setContentView(R.layout.activity_main)

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityViewRoomDetailBinding.inflate(layoutInflater)

        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        // 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시 합니다.
        setContentView(R.layout.activity_view_room_detail)

        val roomData = intent.getSerializableExtra("room", Room::class.java)

        if (roomData != null) {

            binding.priceTxt.text = roomData.getFormattedPrice()
            binding.addressTxt.text = roomData.address
        }
    }
}