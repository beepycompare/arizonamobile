package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-api@@22.5.0 */
/* loaded from: classes4.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnalyticsConnector lambda$getComponents$0(ComponentContainer componentContainer) {
        return AnalyticsConnectorImpl.getInstance((FirebaseApp) componentContainer.get(FirebaseApp.class), (Context) componentContainer.get(Context.class), (Subscriber) componentContainer.get(Subscriber.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(AnalyticsConnector.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(Context.class)).add(Dependency.required(Subscriber.class)).factory(zzb.zza).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-analytics", "22.5.0"));
    }
}
