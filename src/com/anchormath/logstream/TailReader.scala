/**
 * Copyright (C) 2009 alaz <azarov@osinka.ru>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.anchormath.logstream

import com.osinka.tailf.Tail

object TailReader {
  def start(file: String, parser: LogParser): Unit = {
    import java.io.{ File, BufferedReader, InputStreamReader }

    val f = new File(file)
    val r = new BufferedReader(new InputStreamReader(Tail.follow(f)))

    def read: Unit = {

      val l = r.readLine;
      if (l != null) {
        parser.parse(l);
        read
      }
    }

    read
  }
}
