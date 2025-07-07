package com.arkivanov.decompose.router.webhistory;

import kotlin.Metadata;
/* compiled from: WebNavigationOwner.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0006R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/decompose/router/webhistory/WebNavigationOwner;", "", "webNavigation", "Lcom/arkivanov/decompose/router/webhistory/WebNavigation;", "getWebNavigation", "()Lcom/arkivanov/decompose/router/webhistory/WebNavigation;", "NoOp", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface WebNavigationOwner {
    WebNavigation<?> getWebNavigation();

    /* compiled from: WebNavigationOwner.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/arkivanov/decompose/router/webhistory/WebNavigationOwner$NoOp;", "Lcom/arkivanov/decompose/router/webhistory/WebNavigationOwner;", "webNavigation", "Lcom/arkivanov/decompose/router/webhistory/WebNavigation;", "getWebNavigation", "()Lcom/arkivanov/decompose/router/webhistory/WebNavigation;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface NoOp extends WebNavigationOwner {
        @Override // com.arkivanov.decompose.router.webhistory.WebNavigationOwner
        WebNavigation<?> getWebNavigation();

        /* compiled from: WebNavigationOwner.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class DefaultImpls {
            public static WebNavigation<?> getWebNavigation(NoOp noOp) {
                return NoOpWebNavigation.INSTANCE;
            }
        }
    }
}
