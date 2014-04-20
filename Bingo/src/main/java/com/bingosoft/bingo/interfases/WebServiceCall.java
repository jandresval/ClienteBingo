package com.bingosoft.bingo.interfases;


import com.bingosoft.bingo.utils.StringUtils;

import org.apache.commons.lang.math.NumberUtils;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.IOException;
import java.net.Proxy;
import java.net.SocketTimeoutException;

/**
 * Created by Jaime on 2014-04-18.
 */
public class WebServiceCall {

    private String MAIN_REQUEST_URL = "http://192.168.0.118:8090/BasicOperation.svc";
    private String NAMESPACE = "http://tempuri.org/";

    public WebServiceCall() {
    }

    public WebServiceCall(String nameSpace) {
        this();
        this.NAMESPACE = nameSpace;
    }

    private final SoapSerializationEnvelope getSoapSerializationEnvelope(SoapObject request) {
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.setAddAdornments(false);
        envelope.setOutputSoapObject(request);

        return envelope;
    }

    private HttpTransportSE getHttpTransportSE() {
        HttpTransportSE ht = new HttpTransportSE(Proxy.NO_PROXY,MAIN_REQUEST_URL,60000);
        ht.debug = true;
        ht.setXmlVersionTag("<!--?xml version=\"1.0\" encoding= \"UTF-8\" ?-->");
        return ht;
    }

    public int IniciarProcesoDescargaTablas(String usuario) {

        String data = null;
        String methodname = "IniciarProcesoDescargaTablas";

        SoapObject request = new SoapObject(NAMESPACE, methodname);

        request.addProperty("name",usuario);

        SoapSerializationEnvelope envelope = getSoapSerializationEnvelope(request);

        HttpTransportSE ht = getHttpTransportSE();

        String soapAction = "http://tempuri.org/IBasicOperation/IniciarProcesoDescargaTablas";

        try {
            ht.call(soapAction, envelope);

            SoapPrimitive resultsString = (SoapPrimitive)envelope.getResponse();

            data = resultsString.toString();

            if (NumberUtils.isNumber(data))
                return Integer.parseInt(data);

        }
        catch (SocketTimeoutException t) {
            t.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (Exception q) {
            q.printStackTrace();
        }

        return 0;
    }

    public String DescargaTablas(String usuario, int ini, int fin) {

        String data = null;
        String methodname = "RetornarTablas";

        SoapObject request = new SoapObject(NAMESPACE, methodname);
        request.addProperty("name",usuario);
        request.addProperty("inicial",ini);
        request.addProperty("final",fin);

        SoapSerializationEnvelope envelope = getSoapSerializationEnvelope(request);

        HttpTransportSE ht = getHttpTransportSE();

        String soapAction = "http://tempuri.org/IBasicOperation/RetornarTablas";

        try {
            ht.call(soapAction, envelope);

            SoapPrimitive resultsString = (SoapPrimitive)envelope.getResponse();

            data = resultsString.toString();

            return data;

        }
        catch (SocketTimeoutException t) {
            t.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (Exception q) {
            q.printStackTrace();
        }
        return "";
    }


}
