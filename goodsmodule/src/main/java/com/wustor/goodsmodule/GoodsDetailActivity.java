package com.wustor.goodsmodule;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wustor.basemodule.BaseActivity;
import com.wustor.routermodule.CartModuleService;
import com.wustor.routermodule.ReflectUtils;

public class GoodsDetailActivity extends BaseActivity {

    private TextView tvModule;
    private Button btnButton;
    private Button btnCall;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    protected void initView() {
        setTitle("商品详情");
        tvModule = findViewById(R.id.tv_module);
        btnButton = findViewById(R.id.btn_jump);
        tvModule.setText("GoodsModule");
        btnButton.setText("跳转到购物车");
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReflectUtils.startActivityWithName(mContext, "com.wustor.cartmodule.CartActivity");
            }
        });
        btnCall = findViewById(R.id.btn_call);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartModuleService moduleCall = (CartModuleService) ReflectUtils.getModuleCall("com.wustor.cartmodule.CartServiceImpl");
                moduleCall.initContext(mContext);
                moduleCall.getCartAmount();
            }
        });


    }
}
