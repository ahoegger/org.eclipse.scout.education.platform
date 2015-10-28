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
package org.eclipse.scout.education.platform.test.debug;

import java.util.List;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.IBean;
import org.eclipse.scout.rt.platform.IBeanManager;
import org.eclipse.scout.rt.platform.IPlatform;
import org.eclipse.scout.rt.platform.IPlatformListener;
import org.eclipse.scout.rt.platform.IgnoreBean;
import org.eclipse.scout.rt.platform.PlatformEvent;
import org.eclipse.scout.rt.testing.platform.runner.PlatformTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PlatformTestRunner.class)
public class D_001_TrackAllBeans {

  @Test
  public void test() {
    // NOP
  }

  @IgnoreBean
  public static class D_001_PlatformListener implements IPlatformListener {
    @Override
    public void stateChanged(PlatformEvent event) {
      if (event.getState() == IPlatform.State.BeanManagerValid) {
        IPlatform platform = event.getSource();
        IBeanManager beanManager = platform.getBeanManager();
        List<IBean<Object>> registeredBeans = beanManager.getRegisteredBeans(Object.class);
        System.out.println("Bean context contains '" + registeredBeans.size() + "' registered beans.");
        for (IBean<Object> b : registeredBeans) {
          System.out.println("-- BEAN '" + b.getBeanClazz().getSimpleName() + "' --");
          System.out.println("  FQN:       '" + b.getBeanClazz().getName() + "'");
          System.out.println("  Singleton: '" + (b.getBeanAnnotation(ApplicationScoped.class) != null) + "'");
          System.out.println("--------");
        }

      }
    }
  }

}
