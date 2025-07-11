package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.impl.Yn;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class UserProfile {

    /* renamed from: a  reason: collision with root package name */
    private final List f1259a;

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedList f1260a;

        /* synthetic */ Builder(int i) {
            this();
        }

        public Builder apply(UserProfileUpdate<? extends Yn> userProfileUpdate) {
            this.f1260a.add(userProfileUpdate);
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this.f1260a, 0);
        }

        private Builder() {
            this.f1260a = new LinkedList();
        }
    }

    /* synthetic */ UserProfile(LinkedList linkedList, int i) {
        this(linkedList);
    }

    public static Builder newBuilder() {
        return new Builder(0);
    }

    public List<UserProfileUpdate<? extends Yn>> getUserProfileUpdates() {
        return this.f1259a;
    }

    private UserProfile(LinkedList linkedList) {
        this.f1259a = CollectionUtils.unmodifiableListCopy(linkedList);
    }
}
