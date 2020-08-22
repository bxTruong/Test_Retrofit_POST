package com.example.test_retrofit_post.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.test_retrofit_post.R;
import com.example.test_retrofit_post.adapter.recyclerview.UserAdapter;
import com.example.test_retrofit_post.adapter.spinner.AddressAdapter;
import com.example.test_retrofit_post.model.Address;
import com.example.test_retrofit_post.model.User;
import com.example.test_retrofit_post.retrofit.call_api.UserCallApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {
    private EditText edtUserName;
    private EditText edtFullName;
    private EditText edtId;
    private RecyclerView rcUser;
    private String full_name, username;
    private int id;
    private UserCallApi userCallApi;
    private List<User> userList;
    private Address address;
    private List<Address> addressList;
    private AppCompatSpinner spAddress;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        findViewById();
        dataAddress();

        Call<List<User>> call = userCallApi.getUser();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(!response.isSuccessful()){
                    tvResult.setText(response.code()+"");
                }
                tvResult.setText(response.code()+"");
                userList = response.body();
                setUpReCyClerView();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                    tvResult.setText(t.getMessage());
            }
        });

    }

    public void addUser(View view) {
        getData();
        putData();
        showData();
        setUpReCyClerView();
    }

    private void findViewById() {
        edtUserName = findViewById(R.id.edtUsername_user);
        edtFullName = findViewById(R.id.edtFullName_User);
        edtId = findViewById(R.id.edtId_User);
        rcUser = findViewById(R.id.rcUser);
        spAddress = findViewById(R.id.spAddress_User);
        tvResult=findViewById(R.id.tvResult);
    }

    private void getData() {
        id = Integer.parseInt(edtId.getText().toString().trim());
        full_name = edtFullName.getText().toString().trim();
        username = edtUserName.getText().toString().trim();
        address = (Address) spAddress.getSelectedItem();

    }

    private void putData() {
        Address address = new Address("cau giay", "dong da", "ha noi", "no hope");
        User user = new User("Garen", "Demacia", 11, address);
        userCallApi.createUser(user);
    }

    private void showData() {
        User user = new User(full_name, username, id, address);
        userCallApi.createUser(user);
        setUpReCyClerView();
    }

    private void setUpReCyClerView() {
        UserAdapter userAdapter = new UserAdapter(userList, this);
        rcUser.setAdapter(userAdapter);

        LinearLayoutManager vertical = new LinearLayoutManager(this);
        rcUser.setLayoutManager(vertical);
    }

    private void dataAddress() {
        Address addressFake = new Address("Vui long chon dia chi", "", "", "");
        Address address = new Address("Duong Dinh Nghe", "Cau Giay", "Ha Noi", "1");
        Address address2 = new Address("Phao Dai Lang", "Dong Da", "Ha Noi", "1");
        Address address3 = new Address("My Dinh", "Nam Tu Liem", "Ha Noi", "1");
        addressList = new ArrayList<>();
        addressList.add(addressFake);
        addressList.add(address);
        addressList.add(address2);
        addressList.add(address3);

        AddressAdapter addressAdapter = new AddressAdapter(addressList, this);
        spAddress.setAdapter(addressAdapter);
    }

}