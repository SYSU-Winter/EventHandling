package sysu.lwt.event_handling;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by 12136 on 2017/2/24.
 */

public class MainActivity extends AppCompatActivity {
    EditText user, password;
    Button b1, b2;
    RadioGroup group;
    RadioButton r1, r2, r3, r4;
    int radio = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        findViewById();
        clicklistener();
    }

    public void findViewById() {
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        group = (RadioGroup) findViewById(R.id.r0);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);
    }

    public void clicklistener() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(user.getText().toString())) {
                    Toast.makeText(MainActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(MainActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("nimabi", "hahah");
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("提示");
                    if (user.getText().toString().equals("Android") &&
                            password.getText().toString().equals("123456")) {
                        builder.setMessage("登陆成功");
                    } else {
                        builder.setMessage("登录失败");
                    }
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "确定按钮被点击", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "取消按钮被点击", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == r1.getId()) {
                    radio = 1;
                    Toast.makeText(MainActivity.this, "学生身份被选中", Toast.LENGTH_SHORT).show();
                } else if (checkedId == r2.getId()) {
                    radio = 2;
                    Toast.makeText(MainActivity.this, "老师身份被选中", Toast.LENGTH_SHORT).show();
                } else if (checkedId == r3.getId()) {
                    radio = 3;
                    Toast.makeText(MainActivity.this, "社团身份被选中", Toast.LENGTH_SHORT).show();
                } else {
                    radio = 4;
                    Toast.makeText(MainActivity.this, "管理身份被选中", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (radio) {
                    case 1:
                        Toast.makeText(MainActivity.this, "学生身份注册功能尚未开启", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "老师身份注册功能尚未开启", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "社团身份注册功能尚未开启", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "管理身份注册功能尚未开启", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
