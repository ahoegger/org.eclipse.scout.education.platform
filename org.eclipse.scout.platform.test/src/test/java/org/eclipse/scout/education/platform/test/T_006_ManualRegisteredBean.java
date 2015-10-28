/*******************************************************************************
 * Copyright (c) 2015 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.scout.education.platform.test;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.BeanMetaData;
import org.eclipse.scout.rt.platform.IBeanManager;
import org.eclipse.scout.rt.platform.IPlatform;
import org.eclipse.scout.rt.platform.IPlatformListener;
import org.eclipse.scout.rt.platform.IgnoreBean;
import org.eclipse.scout.rt.platform.PlatformEvent;
import org.eclipse.scout.rt.testing.platform.runner.PlatformTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PlatformTestRunner.class)
public class T_006_ManualRegisteredBean {

  @Test
  public void test() {

    T_006_BeanInterface bean = BEANS.get(T_006_BeanInterface.class);
    Assert.assertSame(T_006_Bean.class, bean.getClass());

  }

  public static interface T_006_BeanInterface {

  }

  public static class T_006_Bean implements T_006_BeanInterface {

  }

  @IgnoreBean
  public static class T_006_PlatformListener implements IPlatformListener {
    @Override
    public void stateChanged(PlatformEvent event) {
      if (event.getState() == IPlatform.State.BeanManagerPrepared) {
        IPlatform platform = event.getSource();
        IBeanManager beanManager = platform.getBeanManager();

        BeanMetaData beanMetaData = new BeanMetaData(T_006_Bean.class);
        beanMetaData.withApplicationScoped(true);
        beanManager.registerBean(beanMetaData);
      }
    }
  }

}
