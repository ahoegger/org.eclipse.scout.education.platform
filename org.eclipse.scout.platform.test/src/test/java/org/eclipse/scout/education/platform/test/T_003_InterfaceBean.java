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

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.testing.platform.runner.PlatformTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PlatformTestRunner.class)
public class T_003_InterfaceBean {

  @Test
  public void test() {
    T_003_BeanInterface bean01 = BEANS.get(T_003_BeanInterface.class);
    Assert.assertNotNull(bean01);

    Assert.assertSame(bean01.getClass(), T_003_Bean.class);
  }

  @ApplicationScoped
  public static interface T_003_BeanInterface {

  }

  public static class T_003_Bean implements T_003_BeanInterface {

  }

}
