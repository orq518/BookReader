package com.ou.reader;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.ou.reader.base.Constant;
import com.ou.reader.component.AppComponent;
import com.ou.reader.component.DaggerAppComponent;
import com.ou.reader.module.AppModule;
import com.ou.reader.module.BookApiModule;
import com.ou.reader.utils.AppUtils;
import com.ou.reader.utils.FileUtils;
import com.ou.reader.utils.LogUtils;
import com.ou.reader.utils.SharedPreferencesUtil;
import com.sinovoice.hcicloudsdk.api.HciCloudSys;
import com.sinovoice.hcicloudsdk.common.HciErrorCode;
import com.sinovoice.hcicloudsdk.common.InitParam;
import com.umeng.analytics.MobclickAgent;

/**
 * @author yuyh.
 * @date 2016/8/3.
 */
public class ReaderApplication extends Application {

    private static ReaderApplication sInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.sInstance = this;
        initCompoent();
        AppUtils.init(this);
        initPrefs();
        initNightMode();
        initHciCloud();
        initUM();
    }

    public void initUM() {
        /**
         * 当应用在后台运行超过30秒（默认）再回到前端，将被认为是两个独立的session(启动)，例如用户回到home，或进入其他程序，经过一段时间后再返回之前的应用
         * 该方法用于自定义这个间隔，参数为毫秒
         * */
        MobclickAgent.setSessionContinueMillis(30 * 1000);
        MobclickAgent.setDebugMode(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
    }

    public static ReaderApplication getsInstance() {
        return sInstance;
    }

    private void initCompoent() {
        appComponent = DaggerAppComponent.builder()
                .bookApiModule(new BookApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    /**
     * 初始化SharedPreference
     */
    protected void initPrefs() {
        SharedPreferencesUtil.init(getApplicationContext(), getPackageName() + "_preference", Context.MODE_MULTI_PROCESS);
    }

    protected void initNightMode() {
        boolean isNight = SharedPreferencesUtil.getInstance().getBoolean(Constant.ISNIGHT, false);
        LogUtils.d("isNight=" + isNight);
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    protected void initHciCloud() {
        InitParam initparam = new InitParam();
        String authDirPath = getFilesDir().getAbsolutePath();
        initparam.addParam(InitParam.AuthParam.PARAM_KEY_AUTH_PATH, authDirPath);
        initparam.addParam(InitParam.AuthParam.PARAM_KEY_AUTO_CLOUD_AUTH, "no");
        initparam.addParam(InitParam.AuthParam.PARAM_KEY_CLOUD_URL, "test.api.hcicloud.com:8888");
        initparam.addParam(InitParam.AuthParam.PARAM_KEY_DEVELOPER_KEY, "0a5e69f8fb1c019b2d87a17acf200889");
        initparam.addParam(InitParam.AuthParam.PARAM_KEY_APP_KEY, "0d5d5466");
        String logDirPath = FileUtils.createRootPath(this) + "/hcicloud";
        FileUtils.createDir(logDirPath);
        initparam.addParam(InitParam.LogParam.PARAM_KEY_LOG_FILE_PATH, logDirPath);
        initparam.addParam(InitParam.LogParam.PARAM_KEY_LOG_FILE_COUNT, "5");
        initparam.addParam(InitParam.LogParam.PARAM_KEY_LOG_FILE_SIZE, "1024");
        initparam.addParam(InitParam.LogParam.PARAM_KEY_LOG_LEVEL, "5");
        int errCode = HciCloudSys.hciInit(initparam.getStringConfig(), this);
        if (errCode != HciErrorCode.HCI_ERR_NONE) {
            LogUtils.e("HciCloud初始化失败" + errCode);
            return;
        }
        LogUtils.e("HciCloud初始化成功");
    }
}
