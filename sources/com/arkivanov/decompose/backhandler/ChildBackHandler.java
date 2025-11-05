package com.arkivanov.decompose.backhandler;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arkivanov.essenty.backhandler.BackHandler;
import kotlin.Metadata;
/* compiled from: ChildBackHandler.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/arkivanov/decompose/backhandler/ChildBackHandler;", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "priority", "", "getPriority", "()I", "setPriority", "(I)V", TtmlNode.START, "", "stop", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ChildBackHandler extends BackHandler {
    int getPriority();

    boolean isEnabled();

    void setEnabled(boolean z);

    void setPriority(int i);

    void start();

    void stop();
}
