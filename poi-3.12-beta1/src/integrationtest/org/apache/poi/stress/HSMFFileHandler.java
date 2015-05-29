/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */
package org.apache.poi.stress;

import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hsmf.MAPIMessage;
import org.junit.Test;

public class HSMFFileHandler extends POIFSFileHandler {
	@Override
	public void handleFile(InputStream stream) throws Exception {
		MAPIMessage mapi = new MAPIMessage(stream);
		assertNotNull(mapi.getAttachmentFiles());
		assertNotNull(mapi.getDisplayBCC());
		assertNotNull(mapi.getMessageDate());

		/* => Writing isn't yet supported...
		// write out the file
		File file = TempFile.createTempFile("StressTest", ".msg");
		writeToFile(mapi, file);
		
		MAPIMessage read = new MAPIMessage(file.getAbsolutePath());
		assertNotNull(read.getAttachmentFiles());
		assertNotNull(read.getDisplayBCC());
		assertNotNull(read.getMessageDate());
		*/
		
		// writing is not yet supported... handlePOIDocument(mapi);
	}
	
//	private void writeToFile(MAPIMessage mapi, File file)
//			throws FileNotFoundException, IOException {
//		OutputStream stream = new FileOutputStream(file);
//		try {
//			mapi.write(stream);
//		} finally {
//			stream.close();
//		}
//	}

	// a test-case to test this locally without executing the full TestAllFiles
	@Test
	public void test() throws Exception {
		InputStream stream = new FileInputStream("test-data/hsmf/example_received_regular.msg");
		try {
			handleFile(stream);
		} finally {
			stream.close();
		}
	}
}