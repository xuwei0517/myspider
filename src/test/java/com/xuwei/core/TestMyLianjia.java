package com.xuwei.core;

import static org.junit.Assert.*;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.junit.Test;

public class TestMyLianjia {
	
	@Test
	public void test1() throws Exception {
		HttpClientBuilder builder = HttpClients.custom();
		CloseableHttpClient client = builder.build();
		HttpGet httpGet = new HttpGet("http://bj.lianjia.com/chengjiao/");
		CloseableHttpResponse response = client.execute(httpGet);
		String result = EntityUtils.toString(response.getEntity());
		
		HtmlCleaner htmlCleaner = new HtmlCleaner();
		TagNode rootNode = htmlCleaner.clean(result);
	}

}
