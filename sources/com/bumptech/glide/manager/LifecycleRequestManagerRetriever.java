package com.bumptech.glide.manager;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class LifecycleRequestManagerRetriever {
    private final RequestManagerRetriever.RequestManagerFactory factory;
    final Map<androidx.lifecycle.Lifecycle, RequestManager> lifecycleToRequestManager = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LifecycleRequestManagerRetriever(RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.factory = requestManagerFactory;
    }

    RequestManager getOnly(androidx.lifecycle.Lifecycle lifecycle) {
        Util.assertMainThread();
        return this.lifecycleToRequestManager.get(lifecycle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestManager getOrCreate(Context context, Glide glide, final androidx.lifecycle.Lifecycle lifecycle, FragmentManager fragmentManager, boolean z) {
        Util.assertMainThread();
        RequestManager only = getOnly(lifecycle);
        if (only == null) {
            LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(lifecycle);
            RequestManager build = this.factory.build(glide, lifecycleLifecycle, new SupportRequestManagerTreeNode(fragmentManager), context);
            this.lifecycleToRequestManager.put(lifecycle, build);
            lifecycleLifecycle.addListener(new LifecycleListener() { // from class: com.bumptech.glide.manager.LifecycleRequestManagerRetriever.1
                @Override // com.bumptech.glide.manager.LifecycleListener
                public void onStart() {
                }

                @Override // com.bumptech.glide.manager.LifecycleListener
                public void onStop() {
                }

                @Override // com.bumptech.glide.manager.LifecycleListener
                public void onDestroy() {
                    LifecycleRequestManagerRetriever.this.lifecycleToRequestManager.remove(lifecycle);
                }
            });
            if (z) {
                build.onStart();
            }
            return build;
        }
        return only;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class SupportRequestManagerTreeNode implements RequestManagerTreeNode {
        private final FragmentManager childFragmentManager;

        SupportRequestManagerTreeNode(FragmentManager fragmentManager) {
            this.childFragmentManager = fragmentManager;
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public Set<RequestManager> getDescendants() {
            HashSet hashSet = new HashSet();
            getChildFragmentsRecursive(this.childFragmentManager, hashSet);
            return hashSet;
        }

        private void getChildFragmentsRecursive(FragmentManager fragmentManager, Set<RequestManager> set) {
            List<Fragment> fragments = fragmentManager.getFragments();
            int size = fragments.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = fragments.get(i);
                getChildFragmentsRecursive(fragment.getChildFragmentManager(), set);
                RequestManager only = LifecycleRequestManagerRetriever.this.getOnly(fragment.getLifecycle());
                if (only != null) {
                    set.add(only);
                }
            }
        }
    }
}
