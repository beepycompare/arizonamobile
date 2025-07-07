package com.wardrumstudios.utils;

import android.app.Activity;
import android.view.SurfaceView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
/* loaded from: classes4.dex */
public class WarAdMob {
    private static final int AD_Failed = 2;
    private static final int AD_FailedToLoad = 3;
    private static final int AD_LoadInit = 0;
    private static final int AD_Loaded = 2;
    private static final int AD_Requested = 1;
    private static final int AD_Shown = 1;
    private static final int AD_ShownInit = 0;
    private static final String TAG = "WarAdMob";
    private String TestDeviceId;
    private InterstitialAd mInterstitialAd;
    public SurfaceView surfaceView;
    public Activity warActivity;
    private int adLoadResult = 0;
    private int adShowResult = 0;
    protected WarAdMob WarAds = this;

    public WarAdMob(WarBase warBase, SurfaceView surfaceView, String str, String str2) {
        this.TestDeviceId = "";
        jniWarAdMob();
        this.warActivity = warBase;
        this.surfaceView = surfaceView;
        this.TestDeviceId = str;
        InterstitialAd interstitialAd = new InterstitialAd(warBase);
        this.mInterstitialAd = interstitialAd;
        interstitialAd.setAdUnitId(str2);
        requestNewInterstitial();
        this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.wardrumstudios.utils.WarAdMob.1
            public void onAdClosed() {
                System.out.println("onAdClosed");
                WarAdMob.this.adShowResult = 1;
                WarAdMob.this.requestNewInterstitial();
                WarAdMob.this.adLoadResult = 1;
            }

            public void onAdFailedToLoad(int i) {
                System.out.println("onAdFailedToLoad errorCode " + i);
                WarAdMob.this.adLoadResult = 3;
            }

            public void onAdLoaded() {
                System.out.println("onAdLoaded");
                WarAdMob.this.adLoadResult = 2;
            }
        });
        new RelativeLayout(warBase).addView(this.surfaceView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestNewInterstitial() {
        this.mInterstitialAd.loadAd((this.TestDeviceId.length() == 0 ? new AdRequest.Builder() : new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice(this.TestDeviceId)).build());
    }

    public int GetAdState(int i) {
        return i == 0 ? this.adLoadResult : this.adShowResult;
    }

    public void ShowAdPopup() {
        WarAdMob warAdMob = this.WarAds;
        if (warAdMob != null) {
            warAdMob.ShowInterstitialAd();
        } else {
            System.out.println("WarAds is null.");
        }
    }

    public void ShowInterstitialAd() {
        this.warActivity.runOnUiThread(new Runnable() { // from class: com.wardrumstudios.utils.WarAdMob.2
            @Override // java.lang.Runnable
            public void run() {
                WarAdMob warAdMob;
                int i;
                if (WarAdMob.this.mInterstitialAd.isLoaded()) {
                    WarAdMob.this.mInterstitialAd.show();
                    warAdMob = WarAdMob.this;
                    i = 1;
                } else {
                    System.out.println("Ad not loaded for showing.");
                    warAdMob = WarAdMob.this;
                    i = 2;
                }
                warAdMob.adShowResult = i;
            }
        });
    }

    public native void jniWarAdMob();
}
