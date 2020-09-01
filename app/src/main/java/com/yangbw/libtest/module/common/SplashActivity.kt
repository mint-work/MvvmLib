package com.yangbw.libtest.module.common

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextUtils
import android.view.View
import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.util.SPUtils
import com.library.common.base.BaseActivity
import com.permissionx.guolindev.PermissionX
import com.yangbw.libtest.R
import com.yangbw.libtest.common.CommonViewModel
import com.yangbw.libtest.common.Constant
import com.yangbw.libtest.module.login.LoginActivity
import kotlinx.android.synthetic.main.activity_splash.*


/**
 * 启动页
 *
 * @author yangbw
 * @date 2020/9/1
 */
class SplashActivity : BaseActivity<CommonViewModel, ViewDataBinding>() {

    companion object {
        fun launch(context: Context) {
            context.startActivity(Intent().apply {
                setClass(context, SplashActivity::class.java)
            })
        }
    }

    override fun getLayoutId() = R.layout.activity_splash

    override fun getReplaceView(): View = activity_splash

    override fun getStatusBarColor() = R.color.white

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWriteExternalStoragePermission()
    }

    override fun init(savedInstanceState: Bundle?) {

    }

    private val mCountDownTimer = object : CountDownTimer(3000, 1000) {
        override fun onFinish() {
            val token = SPUtils.getInstance().getString(Constant.TOKEN)
            if (!TextUtils.isEmpty(token)) {
                MainActivity.launch(mContext)
            } else {
                LoginActivity.launch(mContext)
            }
            finish()
        }

        override fun onTick(millisUntilFinished: Long) {

        }
    }

    private fun requestWriteExternalStoragePermission() {
        PermissionX.init(this@SplashActivity)
            .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .onExplainRequestReason { scope, deniedList ->
                scope.showRequestReasonDialog(
                    deniedList, getString(R.string.set_limits_tips),
                    getString(R.string.confirm)
                )
            }
            .onForwardToSettings { scope, deniedList ->
                scope.showForwardToSettingsDialog(
                    deniedList, getString(R.string.go_set_tips),
                    getString(R.string.go_set)
                )
            }
            .request { _, _, _ ->
                mCountDownTimer.start()
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        mCountDownTimer.cancel()
    }

}