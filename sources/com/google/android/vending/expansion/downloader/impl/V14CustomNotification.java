package com.google.android.vending.expansion.downloader.impl;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.vending.expansion.downloader.Helpers;
import com.google.android.vending.expansion.downloader.impl.DownloadNotification;
/* loaded from: classes4.dex */
public class V14CustomNotification implements DownloadNotification.ICustomNotification {
    int mIcon;
    PendingIntent mPendingIntent;
    CharSequence mTicker;
    long mTimeRemaining;
    CharSequence mTitle;
    long mTotalKB = -1;
    long mCurrentKB = -1;

    @Override // com.google.android.vending.expansion.downloader.impl.DownloadNotification.ICustomNotification
    public void setCurrentBytes(long j) {
        this.mCurrentKB = j;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloadNotification.ICustomNotification
    public void setIcon(int i) {
        this.mIcon = i;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloadNotification.ICustomNotification
    public void setPendingIntent(PendingIntent pendingIntent) {
        this.mPendingIntent = pendingIntent;
    }

    void setProgress(Notification.Builder builder) {
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloadNotification.ICustomNotification
    public void setTicker(CharSequence charSequence) {
        this.mTicker = charSequence;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloadNotification.ICustomNotification
    public void setTimeRemaining(long j) {
        this.mTimeRemaining = j;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloadNotification.ICustomNotification
    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloadNotification.ICustomNotification
    public void setTotalBytes(long j) {
        this.mTotalKB = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    @Override // com.google.android.vending.expansion.downloader.impl.DownloadNotification.ICustomNotification
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Notification.Builder updateNotification(Context context) {
        int i;
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(this.mTitle);
        long j = this.mTotalKB;
        if (j > 0) {
            long j2 = this.mCurrentKB;
            if (-1 != j2) {
                builder.setProgress((int) (j >> 8), (int) (j2 >> 8), false);
                builder.setContentText(Helpers.getDownloadProgressString(this.mCurrentKB, this.mTotalKB));
                builder.setContentInfo(context.getString(Helpers.GetResourceIdentifier(context, "time_remaining_notification", TypedValues.Custom.S_STRING), Helpers.getTimeRemaining(this.mTimeRemaining)));
                i = this.mIcon;
                if (i == 0) {
                    i = 17301633;
                }
                builder.setSmallIcon(i);
                builder.setOngoing(true);
                builder.setTicker(this.mTicker);
                builder.setContentIntent(this.mPendingIntent);
                builder.setOnlyAlertOnce(true);
                return builder;
            }
        }
        builder.setProgress(0, 0, true);
        builder.setContentText(Helpers.getDownloadProgressString(this.mCurrentKB, this.mTotalKB));
        builder.setContentInfo(context.getString(Helpers.GetResourceIdentifier(context, "time_remaining_notification", TypedValues.Custom.S_STRING), Helpers.getTimeRemaining(this.mTimeRemaining)));
        i = this.mIcon;
        if (i == 0) {
        }
        builder.setSmallIcon(i);
        builder.setOngoing(true);
        builder.setTicker(this.mTicker);
        builder.setContentIntent(this.mPendingIntent);
        builder.setOnlyAlertOnce(true);
        return builder;
    }
}
