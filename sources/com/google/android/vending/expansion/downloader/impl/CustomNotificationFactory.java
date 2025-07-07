package com.google.android.vending.expansion.downloader.impl;

import com.google.android.vending.expansion.downloader.impl.DownloadNotification;
/* loaded from: classes4.dex */
public class CustomNotificationFactory {
    public static DownloadNotification.ICustomNotification createCustomNotification() {
        return new V14CustomNotification();
    }
}
