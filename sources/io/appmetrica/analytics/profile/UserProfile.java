package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.impl.InterfaceC0254fo;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class UserProfile {

    /* renamed from: a  reason: collision with root package name */
    private final List f1422a;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedList f1423a;

        /* synthetic */ Builder(int i) {
            this();
        }

        public Builder apply(UserProfileUpdate<? extends InterfaceC0254fo> userProfileUpdate) {
            this.f1423a.add(userProfileUpdate);
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this.f1423a, 0);
        }

        private Builder() {
            this.f1423a = new LinkedList();
        }
    }

    /* synthetic */ UserProfile(LinkedList linkedList, int i) {
        this(linkedList);
    }

    public static Builder newBuilder() {
        return new Builder(0);
    }

    public List<UserProfileUpdate<? extends InterfaceC0254fo>> getUserProfileUpdates() {
        return this.f1422a;
    }

    private UserProfile(LinkedList linkedList) {
        this.f1422a = CollectionUtils.unmodifiableListCopy(linkedList);
    }
}
