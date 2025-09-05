package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.impl.InterfaceC0391ko;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class UserProfile {

    /* renamed from: a  reason: collision with root package name */
    private final List f1277a;

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedList f1278a;

        /* synthetic */ Builder(int i) {
            this();
        }

        public Builder apply(UserProfileUpdate<? extends InterfaceC0391ko> userProfileUpdate) {
            this.f1278a.add(userProfileUpdate);
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this.f1278a, 0);
        }

        private Builder() {
            this.f1278a = new LinkedList();
        }
    }

    /* synthetic */ UserProfile(LinkedList linkedList, int i) {
        this(linkedList);
    }

    public static Builder newBuilder() {
        return new Builder(0);
    }

    public List<UserProfileUpdate<? extends InterfaceC0391ko>> getUserProfileUpdates() {
        return this.f1277a;
    }

    private UserProfile(LinkedList linkedList) {
        this.f1277a = CollectionUtils.unmodifiableListCopy(linkedList);
    }
}
