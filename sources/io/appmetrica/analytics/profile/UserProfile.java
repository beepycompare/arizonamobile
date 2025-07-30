package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.impl.InterfaceC0166bo;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class UserProfile {

    /* renamed from: a  reason: collision with root package name */
    private final List f1263a;

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedList f1264a;

        /* synthetic */ Builder(int i) {
            this();
        }

        public Builder apply(UserProfileUpdate<? extends InterfaceC0166bo> userProfileUpdate) {
            this.f1264a.add(userProfileUpdate);
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this.f1264a, 0);
        }

        private Builder() {
            this.f1264a = new LinkedList();
        }
    }

    /* synthetic */ UserProfile(LinkedList linkedList, int i) {
        this(linkedList);
    }

    public static Builder newBuilder() {
        return new Builder(0);
    }

    public List<UserProfileUpdate<? extends InterfaceC0166bo>> getUserProfileUpdates() {
        return this.f1263a;
    }

    private UserProfile(LinkedList linkedList) {
        this.f1263a = CollectionUtils.unmodifiableListCopy(linkedList);
    }
}
