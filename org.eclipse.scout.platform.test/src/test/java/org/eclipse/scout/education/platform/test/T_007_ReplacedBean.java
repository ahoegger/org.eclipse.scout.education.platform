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

import java.util.List;

import org.eclipse.scout.commons.annotations.Replace;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.testing.platform.runner.PlatformTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PlatformTestRunner.class)
public class T_007_ReplacedBean {

  @Test
  public void test() {
    T_007_BeanInterface bean = BEANS.get(T_007_BeanInterface.class);
    Assert.assertSame(T_007_Bean2.class, bean.getClass());

    List<T_007_BeanInterface> all = BEANS.all(T_007_BeanInterface.class);
    Assert.assertEquals(1, all.size());
  }

  @ApplicationScoped
  public static interface T_007_BeanInterface {

  }

  public static class T_007_Bean1 implements T_007_BeanInterface {

  }

  @Replace
  public static class T_007_Bean2 extends T_007_Bean1 {

  }

}
