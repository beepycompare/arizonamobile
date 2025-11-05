package com.arkivanov.decompose.router.children;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
/* compiled from: NavStateSaver.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/arkivanov/decompose/router/children/NavStateSaver;", ExifInterface.GPS_DIRECTION_TRUE, "", "saveState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", RemoteConfigConstants.ResponseFieldKey.STATE, "(Ljava/lang/Object;)Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "restoreState", TtmlNode.RUBY_CONTAINER, "(Lcom/arkivanov/essenty/statekeeper/SerializableContainer;)Ljava/lang/Object;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface NavStateSaver<T> {
    T restoreState(SerializableContainer serializableContainer);

    SerializableContainer saveState(T t);
}
