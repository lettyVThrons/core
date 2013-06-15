//-----BEGIN DISCLAIMER-----
/*******************************************************************************
* Copyright (c) 2008 JCrypTool Team and Contributors
* 
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
//-----END DISCLAIMER-----
package org.jcryptool.crypto.keystore.ui.actions.del;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.jcryptool.crypto.keystore.KeyStorePlugin;
import org.jcryptool.crypto.keystore.backend.KeyStoreManager;
import org.jcryptool.crypto.keystore.ui.views.interfaces.ISelectedNodeListener;

/**
 * @author t-kern
 *
 */
public class DeleteKeyPairAction extends Action {

	private ISelectedNodeListener descriptor;

	public DeleteKeyPairAction(ISelectedNodeListener descriptor) {
		this.descriptor = descriptor;
		this.setText(Messages.getString("Label.DeleteKeyPair")); //$NON-NLS-1$
		this.setToolTipText(Messages.getString("Label.DeleteKeyPair"));	 //$NON-NLS-1$
		this.setImageDescriptor(KeyStorePlugin.getImageDescriptor("icons/16x16/cancel.png")); //$NON-NLS-1$
	}
	
	public void run() {
		boolean result = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), Messages.getString("Label.DeleteKeyPair"), Messages.getString("Label.AreYouSureKeyPair")); //$NON-NLS-1$ //$NON-NLS-2$
		if (result) {				
			KeyStoreManager.getInstance().deleteEntry(descriptor.getSelectedNodeAlias());	
		}
	}
	
}
