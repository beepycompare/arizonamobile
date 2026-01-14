package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.impl.InterfaceC0233eo;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class UserProfile {

    /* renamed from: a  reason: collision with root package name */
    private final List f1432a;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedList f1433a;

        /* synthetic */ Builder(int i) {
            this();
        }

        public Builder apply(UserProfileUpdate<? extends InterfaceC0233eo> userProfileUpdate) {
            this.f1433a.add(userProfileUpdate);
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this.f1433a, 0);
        }

        private Builder() {
            this.f1433a = new LinkedList();
        }
    }

    /* synthetic */ UserProfile(LinkedList linkedList, int i) {
        this(linkedList);
    }

    public static Builder newBuilder() {
        return new Builder(0);
    }

    public List<UserProfileUpdate<? extends InterfaceC0233eo>> getUserProfileUpdates() {
        return this.f1432a;
    }

    private UserProfile(LinkedList linkedList) {
        this.f1432a = CollectionUtils.unmodifiableListCopy(linkedList);
    }
}
