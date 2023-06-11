package com.cnc.landapp_kh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.cnc.landapp_kh.adapters.RoomAdapter
import com.cnc.landapp_kh.databinding.ActivityMainBinding
import com.cnc.landapp_kh.datas.Room


class MainActivity : AppCompatActivity() {

    val mRoomList = ArrayList<Room>()

    lateinit var mRoomAdapter: RoomAdapter

    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 기존 setContentView 를 제거해주시고..
//        setContentView(R.layout.activity_main)

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        // 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시 합니다.
        setContentView(binding.root)


        mRoomList.add(Room(7500,"서울시 동대문구", 8, "서울시 동대문구의 8층 7500만원 방입니다."))
        mRoomList.add(Room(6500,"서울시 서대문구", -2, "서울시 서대문구의 8층 7500만원 방입니다."))

        mRoomAdapter = RoomAdapter(this, R.layout.room_list_item, mRoomList)
        binding.roomListView.adapter = mRoomAdapter


    }


}