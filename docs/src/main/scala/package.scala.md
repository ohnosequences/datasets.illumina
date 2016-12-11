
```scala
package ohnosequences.datasets

package object illumina {

  type SingleEndType = singleEndType.type
  val SingleEndType: SingleEndType = singleEndType

  type PairedEndType = pairedEndType.type
  val PairedEndType: PairedEndType = pairedEndType
}

```




[main/scala/package.scala]: package.scala.md
[main/scala/reads.scala]: reads.scala.md