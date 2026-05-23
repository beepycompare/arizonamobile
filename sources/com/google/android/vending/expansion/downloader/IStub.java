package com.google.android.vending.expansion.downloader;

import android.content.Context;
import android.os.Messenger;
/* loaded from: classes5.dex */
public interface IStub {
    void connect(Context context);

    void disconnect(Context context);

    Messenger getMessenger();
}
