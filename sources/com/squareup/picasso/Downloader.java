package com.squareup.picasso;

import java.io.IOException;
import okhttp3.Response;
/* loaded from: classes4.dex */
public interface Downloader {
    Response load(okhttp3.Request request) throws IOException;

    void shutdown();
}
