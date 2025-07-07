package com.arkivanov.decompose.backhandler;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arkivanov.essenty.backhandler.BackHandler;
import kotlin.Metadata;
/* compiled from: ChildBackHandler.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/arkivanov/decompose/backhandler/ChildBackHandler;", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "isEnabled", "", "()Z", "setEnabled", "(Z)V", TtmlNode.START, "", "stop", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ChildBackHandler extends BackHandler {
    boolean isEnabled();

    void setEnabled(boolean z);

    void start();

    void stop();
}
