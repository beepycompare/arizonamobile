package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class AutoBatchedLogRequestEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoBatchedLogRequestEncoder();

    private AutoBatchedLogRequestEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(BatchedLogRequest.class, BatchedLogRequestEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_BatchedLogRequest.class, BatchedLogRequestEncoder.INSTANCE);
        encoderConfig.registerEncoder(LogRequest.class, LogRequestEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_LogRequest.class, LogRequestEncoder.INSTANCE);
        encoderConfig.registerEncoder(ClientInfo.class, ClientInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_ClientInfo.class, ClientInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(AndroidClientInfo.class, AndroidClientInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_AndroidClientInfo.class, AndroidClientInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(LogEvent.class, LogEventEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_LogEvent.class, LogEventEncoder.INSTANCE);
        encoderConfig.registerEncoder(ComplianceData.class, ComplianceDataEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_ComplianceData.class, ComplianceDataEncoder.INSTANCE);
        encoderConfig.registerEncoder(ExternalPrivacyContext.class, ExternalPrivacyContextEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_ExternalPrivacyContext.class, ExternalPrivacyContextEncoder.INSTANCE);
        encoderConfig.registerEncoder(ExternalPRequestContext.class, ExternalPRequestContextEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_ExternalPRequestContext.class, ExternalPRequestContextEncoder.INSTANCE);
        encoderConfig.registerEncoder(NetworkConnectionInfo.class, NetworkConnectionInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_NetworkConnectionInfo.class, NetworkConnectionInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(ExperimentIds.class, ExperimentIdsEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_ExperimentIds.class, ExperimentIdsEncoder.INSTANCE);
    }

    /* loaded from: classes3.dex */
    private static final class BatchedLogRequestEncoder implements ObjectEncoder<BatchedLogRequest> {
        static final BatchedLogRequestEncoder INSTANCE = new BatchedLogRequestEncoder();
        private static final FieldDescriptor LOGREQUEST_DESCRIPTOR = FieldDescriptor.of("logRequest");

        private BatchedLogRequestEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(BatchedLogRequest batchedLogRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(LOGREQUEST_DESCRIPTOR, batchedLogRequest.getLogRequests());
        }
    }

    /* loaded from: classes3.dex */
    private static final class LogRequestEncoder implements ObjectEncoder<LogRequest> {
        static final LogRequestEncoder INSTANCE = new LogRequestEncoder();
        private static final FieldDescriptor REQUESTTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestTimeMs");
        private static final FieldDescriptor REQUESTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestUptimeMs");
        private static final FieldDescriptor CLIENTINFO_DESCRIPTOR = FieldDescriptor.of("clientInfo");
        private static final FieldDescriptor LOGSOURCE_DESCRIPTOR = FieldDescriptor.of("logSource");
        private static final FieldDescriptor LOGSOURCENAME_DESCRIPTOR = FieldDescriptor.of("logSourceName");
        private static final FieldDescriptor LOGEVENT_DESCRIPTOR = FieldDescriptor.of("logEvent");
        private static final FieldDescriptor QOSTIER_DESCRIPTOR = FieldDescriptor.of("qosTier");

        private LogRequestEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(LogRequest logRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(REQUESTTIMEMS_DESCRIPTOR, logRequest.getRequestTimeMs());
            objectEncoderContext.add(REQUESTUPTIMEMS_DESCRIPTOR, logRequest.getRequestUptimeMs());
            objectEncoderContext.add(CLIENTINFO_DESCRIPTOR, logRequest.getClientInfo());
            objectEncoderContext.add(LOGSOURCE_DESCRIPTOR, logRequest.getLogSource());
            objectEncoderContext.add(LOGSOURCENAME_DESCRIPTOR, logRequest.getLogSourceName());
            objectEncoderContext.add(LOGEVENT_DESCRIPTOR, logRequest.getLogEvents());
            objectEncoderContext.add(QOSTIER_DESCRIPTOR, logRequest.getQosTier());
        }
    }

    /* loaded from: classes3.dex */
    private static final class ClientInfoEncoder implements ObjectEncoder<ClientInfo> {
        static final ClientInfoEncoder INSTANCE = new ClientInfoEncoder();
        private static final FieldDescriptor CLIENTTYPE_DESCRIPTOR = FieldDescriptor.of("clientType");
        private static final FieldDescriptor ANDROIDCLIENTINFO_DESCRIPTOR = FieldDescriptor.of("androidClientInfo");

        private ClientInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(CLIENTTYPE_DESCRIPTOR, clientInfo.getClientType());
            objectEncoderContext.add(ANDROIDCLIENTINFO_DESCRIPTOR, clientInfo.getAndroidClientInfo());
        }
    }

    /* loaded from: classes3.dex */
    private static final class AndroidClientInfoEncoder implements ObjectEncoder<AndroidClientInfo> {
        static final AndroidClientInfoEncoder INSTANCE = new AndroidClientInfoEncoder();
        private static final FieldDescriptor SDKVERSION_DESCRIPTOR = FieldDescriptor.of(RemoteConfigConstants.RequestFieldKey.SDK_VERSION);
        private static final FieldDescriptor MODEL_DESCRIPTOR = FieldDescriptor.of(CommonUrlParts.MODEL);
        private static final FieldDescriptor HARDWARE_DESCRIPTOR = FieldDescriptor.of("hardware");
        private static final FieldDescriptor DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
        private static final FieldDescriptor PRODUCT_DESCRIPTOR = FieldDescriptor.of("product");
        private static final FieldDescriptor OSBUILD_DESCRIPTOR = FieldDescriptor.of("osBuild");
        private static final FieldDescriptor MANUFACTURER_DESCRIPTOR = FieldDescriptor.of(CommonUrlParts.MANUFACTURER);
        private static final FieldDescriptor FINGERPRINT_DESCRIPTOR = FieldDescriptor.of("fingerprint");
        private static final FieldDescriptor LOCALE_DESCRIPTOR = FieldDescriptor.of(CommonUrlParts.LOCALE);
        private static final FieldDescriptor COUNTRY_DESCRIPTOR = FieldDescriptor.of("country");
        private static final FieldDescriptor MCCMNC_DESCRIPTOR = FieldDescriptor.of("mccMnc");
        private static final FieldDescriptor APPLICATIONBUILD_DESCRIPTOR = FieldDescriptor.of("applicationBuild");

        private AndroidClientInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(AndroidClientInfo androidClientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(SDKVERSION_DESCRIPTOR, androidClientInfo.getSdkVersion());
            objectEncoderContext.add(MODEL_DESCRIPTOR, androidClientInfo.getModel());
            objectEncoderContext.add(HARDWARE_DESCRIPTOR, androidClientInfo.getHardware());
            objectEncoderContext.add(DEVICE_DESCRIPTOR, androidClientInfo.getDevice());
            objectEncoderContext.add(PRODUCT_DESCRIPTOR, androidClientInfo.getProduct());
            objectEncoderContext.add(OSBUILD_DESCRIPTOR, androidClientInfo.getOsBuild());
            objectEncoderContext.add(MANUFACTURER_DESCRIPTOR, androidClientInfo.getManufacturer());
            objectEncoderContext.add(FINGERPRINT_DESCRIPTOR, androidClientInfo.getFingerprint());
            objectEncoderContext.add(LOCALE_DESCRIPTOR, androidClientInfo.getLocale());
            objectEncoderContext.add(COUNTRY_DESCRIPTOR, androidClientInfo.getCountry());
            objectEncoderContext.add(MCCMNC_DESCRIPTOR, androidClientInfo.getMccMnc());
            objectEncoderContext.add(APPLICATIONBUILD_DESCRIPTOR, androidClientInfo.getApplicationBuild());
        }
    }

    /* loaded from: classes3.dex */
    private static final class LogEventEncoder implements ObjectEncoder<LogEvent> {
        static final LogEventEncoder INSTANCE = new LogEventEncoder();
        private static final FieldDescriptor EVENTTIMEMS_DESCRIPTOR = FieldDescriptor.of("eventTimeMs");
        private static final FieldDescriptor EVENTCODE_DESCRIPTOR = FieldDescriptor.of("eventCode");
        private static final FieldDescriptor COMPLIANCEDATA_DESCRIPTOR = FieldDescriptor.of("complianceData");
        private static final FieldDescriptor EVENTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("eventUptimeMs");
        private static final FieldDescriptor SOURCEEXTENSION_DESCRIPTOR = FieldDescriptor.of("sourceExtension");
        private static final FieldDescriptor SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR = FieldDescriptor.of("sourceExtensionJsonProto3");
        private static final FieldDescriptor TIMEZONEOFFSETSECONDS_DESCRIPTOR = FieldDescriptor.of("timezoneOffsetSeconds");
        private static final FieldDescriptor NETWORKCONNECTIONINFO_DESCRIPTOR = FieldDescriptor.of("networkConnectionInfo");
        private static final FieldDescriptor EXPERIMENTIDS_DESCRIPTOR = FieldDescriptor.of("experimentIds");

        private LogEventEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(LogEvent logEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(EVENTTIMEMS_DESCRIPTOR, logEvent.getEventTimeMs());
            objectEncoderContext.add(EVENTCODE_DESCRIPTOR, logEvent.getEventCode());
            objectEncoderContext.add(COMPLIANCEDATA_DESCRIPTOR, logEvent.getComplianceData());
            objectEncoderContext.add(EVENTUPTIMEMS_DESCRIPTOR, logEvent.getEventUptimeMs());
            objectEncoderContext.add(SOURCEEXTENSION_DESCRIPTOR, logEvent.getSourceExtension());
            objectEncoderContext.add(SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR, logEvent.getSourceExtensionJsonProto3());
            objectEncoderContext.add(TIMEZONEOFFSETSECONDS_DESCRIPTOR, logEvent.getTimezoneOffsetSeconds());
            objectEncoderContext.add(NETWORKCONNECTIONINFO_DESCRIPTOR, logEvent.getNetworkConnectionInfo());
            objectEncoderContext.add(EXPERIMENTIDS_DESCRIPTOR, logEvent.getExperimentIds());
        }
    }

    /* loaded from: classes3.dex */
    private static final class ComplianceDataEncoder implements ObjectEncoder<ComplianceData> {
        static final ComplianceDataEncoder INSTANCE = new ComplianceDataEncoder();
        private static final FieldDescriptor PRIVACYCONTEXT_DESCRIPTOR = FieldDescriptor.of("privacyContext");
        private static final FieldDescriptor PRODUCTIDORIGIN_DESCRIPTOR = FieldDescriptor.of("productIdOrigin");

        private ComplianceDataEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(ComplianceData complianceData, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(PRIVACYCONTEXT_DESCRIPTOR, complianceData.getPrivacyContext());
            objectEncoderContext.add(PRODUCTIDORIGIN_DESCRIPTOR, complianceData.getProductIdOrigin());
        }
    }

    /* loaded from: classes3.dex */
    private static final class ExternalPrivacyContextEncoder implements ObjectEncoder<ExternalPrivacyContext> {
        static final ExternalPrivacyContextEncoder INSTANCE = new ExternalPrivacyContextEncoder();
        private static final FieldDescriptor PREQUEST_DESCRIPTOR = FieldDescriptor.of("prequest");

        private ExternalPrivacyContextEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(ExternalPrivacyContext externalPrivacyContext, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(PREQUEST_DESCRIPTOR, externalPrivacyContext.getPrequest());
        }
    }

    /* loaded from: classes3.dex */
    private static final class ExternalPRequestContextEncoder implements ObjectEncoder<ExternalPRequestContext> {
        static final ExternalPRequestContextEncoder INSTANCE = new ExternalPRequestContextEncoder();
        private static final FieldDescriptor ORIGINASSOCIATEDPRODUCTID_DESCRIPTOR = FieldDescriptor.of("originAssociatedProductId");

        private ExternalPRequestContextEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(ExternalPRequestContext externalPRequestContext, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(ORIGINASSOCIATEDPRODUCTID_DESCRIPTOR, externalPRequestContext.getOriginAssociatedProductId());
        }
    }

    /* loaded from: classes3.dex */
    private static final class NetworkConnectionInfoEncoder implements ObjectEncoder<NetworkConnectionInfo> {
        static final NetworkConnectionInfoEncoder INSTANCE = new NetworkConnectionInfoEncoder();
        private static final FieldDescriptor NETWORKTYPE_DESCRIPTOR = FieldDescriptor.of("networkType");
        private static final FieldDescriptor MOBILESUBTYPE_DESCRIPTOR = FieldDescriptor.of("mobileSubtype");

        private NetworkConnectionInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(NETWORKTYPE_DESCRIPTOR, networkConnectionInfo.getNetworkType());
            objectEncoderContext.add(MOBILESUBTYPE_DESCRIPTOR, networkConnectionInfo.getMobileSubtype());
        }
    }

    /* loaded from: classes3.dex */
    private static final class ExperimentIdsEncoder implements ObjectEncoder<ExperimentIds> {
        static final ExperimentIdsEncoder INSTANCE = new ExperimentIdsEncoder();
        private static final FieldDescriptor CLEARBLOB_DESCRIPTOR = FieldDescriptor.of("clearBlob");
        private static final FieldDescriptor ENCRYPTEDBLOB_DESCRIPTOR = FieldDescriptor.of("encryptedBlob");

        private ExperimentIdsEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(ExperimentIds experimentIds, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(CLEARBLOB_DESCRIPTOR, experimentIds.getClearBlob());
            objectEncoderContext.add(ENCRYPTEDBLOB_DESCRIPTOR, experimentIds.getEncryptedBlob());
        }
    }
}
