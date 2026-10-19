package io.appmetrica.analytics.impl;

import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class I5 {

    /* renamed from: a  reason: collision with root package name */
    public static final List f594a = CollectionUtils.createSortedListWithoutRepetitions(TtmlNode.ATTR_ID, "session_id", "session_type", "number_in_session", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "global_number", "time", "event_description");
}
