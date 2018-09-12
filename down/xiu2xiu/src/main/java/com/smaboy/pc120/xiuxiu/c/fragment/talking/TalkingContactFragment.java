package com.smaboy.pc120.xiuxiu.c.fragment.talking;

import android.Manifest;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.interfaces.OnMyQuickSideBarTouchListener;
import com.smaboy.pc120.xiuxiu.v.customerview.MyQuickSlideBarView;

import java.util.ArrayList;

import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

/**
 * Created by Smaboy
 * Email:405923832@qq.com
 * Better for better
 */

public class TalkingContactFragment extends Fragment {

    private ArrayAdapter<String> contactsAdapter;//列表适配器
    private ArrayList<String> contactsList;//列表数据源
    private ListView listview;
    private MyQuickSlideBarView mquickslidebar;
    private TextView tv_letter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talking_conversation, container, false);

        initview(view);

        setListener();

        setData();

        return view;
    }

    private void setData() {
        //设置listview数据
        contactsList = new ArrayList<>();
        contactsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.
                simple_list_item_1, contactsList);

        //检查是否具备读取联系人的权限
         /*获取当前系统的android版本号*/
        int currentapiVersion = Build.VERSION.SDK_INT;

        if (currentapiVersion >= 23) {//23后添加了运行时权限
            PermissionGen.needPermission(TalkingContactFragment.this, 100, Manifest.permission.
                    READ_CONTACTS);
        }

        listview.setAdapter(contactsAdapter);


//        //准备给listview设置数据
////        1.放入listview的头部：添加联系人，邀请联系人，邀请通知
//        ArrayList<Contact> contactLists=new ArrayList<>();
//        XXContactAdapter contactAdapter=new XXContactAdapter(getContext(),contactLists);
//        listview.setAdapter(contactAdapter);



    }

    private void setListener() {

        //快速索引监听
        mquickslidebar.setOnQuickSideBarTouchListener(new OnMyQuickSideBarTouchListener() {
            @Override
            public void onLetterChanged(String letter, int position, float y) {

                Log.e("letter", "-----------" + letter + "," + position + "," + y);

                tv_letter.setText(letter);
            }

            @Override
            public void onLetterTouching(boolean touching) {

                if (touching) {
                    tv_letter.setVisibility(View.VISIBLE);
                } else {

                    tv_letter.setVisibility(View.GONE);

                }
            }
        });



    }

    private void initview(View view) {
        listview = (ListView) view.findViewById(R.id.list_view);
        mquickslidebar = (MyQuickSlideBarView) view.findViewById(R.id.quickslidebar);
        tv_letter = (TextView) view.findViewById(R.id.tv_letter);


    }

    //读取联系人
    private void readContacts() {
        contactsList.clear();//清空数据
        Cursor cursor = null;//用于读取数据的游标
        try {
            //使用Android预定义的Uri对象查询数据
            cursor = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));//姓名
                    String phoneNumber = cursor.getString(cursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER));//电话号码
                    contactsList.add(name + " " + phoneNumber);
                } while (cursor.moveToNext());
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {//关闭资源
                cursor.close();
            }
        }
        contactsAdapter.notifyDataSetChanged();//刷新列表数据
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(TalkingContactFragment.this, 100, permissions, grantResults);

    }

    @PermissionSuccess(requestCode = 100)
    public void doSomething() {
        readContacts();

    }

    @PermissionFail(requestCode = 100)
    public void doFailSomething() {

    }

}
