package com.findtheway;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SUTHAWEEWERAPHONG on 12/7/2017.
 */

public class CustomAdapterdis extends BaseAdapter {
    Context mContext;
    ArrayList<dis> disArray;   // ตัวแปรที่เป็นที่เก็บข้อมูล อยู่ภายใน Adapter
    public CustomAdapterdis(Context context, ArrayList<dis> disArray){
        this.mContext = context;
        this.disArray = disArray;
    }
    @Override
    public int getCount() {
        return disArray.size();
    }

    @Override
    public Object getItem(int position) {
        return disArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // ฟังก์ชั่นที่เปลี่ยน index ของ ArrayList ของ Bus เป็น View
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        // LayoutInflater ทำหน้าที่เป็นตัวที่จะ inflate layout มาจากไฟล์ XML ที่อยู่ใน res
        LayoutInflater mInflater =
                (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ใน ListView จะมี View ย่อยๆหลายตัว (ซึ่งบางครั้ง view ก็ยังไม่ถูกสร้าง (ยังไม่โหลด UI))
        if(view == null)  // <- ถ้ายังไม่เคยถูกสร้าง
            // สร้าง view ที่จะแสดงใน ListView โดยการเรียกใช้ inflater สั่ง inflate layput มาจากไฟล์ที่ชื่อ simple_list_item_1 (ของ android)
            view = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
//        Log.d("testCustomAdapterbus",""+view);
        // (หากต้องการให้เป็นตัวอื่นที่ไม่ใช่ TextView ธรรมดา ก็จำเป็นต้องสร้าง xml อันใหม่ขึ้นมาใน Folder Layout แล้ว inflate ไฟล์นั้นแทน)

        TextView textView = (TextView)view.findViewById(android.R.id.text1);
        dis b = disArray.get(position);  // อันนี้คือตัวแปร b เป็นประเภท Bus ที่อยู่ใน ArrayList ตำแหน่งที่ position
//        String text = b.getName();      // อันนี้คือตัวแปร text ป็นประเภท String ที่ได้จากการเอาข้อมูล line ออกมาจาก Bus
//        textView.setText(text);
//        textView.setOnContextClickListener();
        return view;
    }
}
