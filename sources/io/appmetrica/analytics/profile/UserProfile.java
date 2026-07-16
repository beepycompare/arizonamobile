package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.impl.Ho;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class UserProfile {

    /* renamed from: a  reason: collision with root package name */
    private final List f1421a;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedList f1422a;

        /* synthetic */ Builder(int i) {
            this();
        }

        public Builder apply(UserProfileUpdate<? extends Ho> userProfileUpdate) {
            this.f1422a.add(userProfileUpdate);
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this.f1422a, 0);
        }

        private Builder() {
            this.f1422a = new LinkedList();
        }
    }

    /* synthetic */ UserProfile(LinkedList linkedList, int i) {
        this(linkedList);
    }

    public static Builder newBuilder() {
        return new Builder(0);
    }

    public List<UserProfileUpdate<? extends Ho>> getUserProfileUpdates() {
        return this.f1421a;
    }

    private UserProfile(LinkedList linkedList) {
        this.f1421a = CollectionUtils.unmodifiableListCopy(linkedList);
    }
}
