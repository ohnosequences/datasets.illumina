package ohnosequences.datasets.illumina

import ohnosequences.datasets._

/*
  ### Illumina reads
*/
trait AnyReadsData extends AnyData {

  type InsertSize <: AnyInsertSize
  val  insertSize: InsertSize

  type EndType <: AnyEndType
  val  endType: EndType

  type Length <: AnyLength
  val  length: Length

  lazy val labelPrefix: String = s"Illumina.${endType}.${length.toInt}"
}

abstract class ReadsData[
  InsrtSz <: AnyInsertSize,
  EndTp   <: AnyEndType,
  Lngth   <: AnyLength
](val endType: EndTp,
  val length: Lngth,
  val insertSize: InsrtSz
) extends AnyReadsData {

  type InsertSize = InsrtSz
  type Length     = Lngth
  type EndType    = EndTp
}

// Illumina insert size
sealed trait AnyInsertSize { val size: Option[Int] }
case object unknownInsertSize         extends AnyInsertSize { val size = None    }
case class  InsertSize(val s: Int)    extends AnyInsertSize { val size = Some(s) }

// Illumina (runs?) are either single-end or paired-end
sealed trait AnyEndType
case object singleEndType extends AnyEndType
case object pairedEndType extends AnyEndType

sealed trait AnyLength { val toInt: Int }
class Length(val toInt: Int) extends AnyLength
case object bp300 extends Length(300)
case object bp250 extends Length(250)
case object bp150 extends Length(150)
case object bp100 extends Length(100)
case object bp75  extends Length(75)
case object bp50  extends Length(50)

class SingleEndReads[
  InsrtSz <: AnyInsertSize,
  Lngth <: AnyLength
](val l: Lngth, val is: InsrtSz)(val label: String)
  extends ReadsData(singleEndType, l, is)


class PairedEndReads1[
  InsrtSz <: AnyInsertSize,
  Lngth <: AnyLength
](val l: Lngth, val is: InsrtSz)(val label: String)
  extends ReadsData(pairedEndType, l, is)

class PairedEndReads2[
  InsrtSz <: AnyInsertSize,
  Lngth <: AnyLength
](val l: Lngth, val is: InsrtSz)(val label: String)
  extends ReadsData(pairedEndType, l, is)



// TODO if there's any use of this, it should go into some AnyDataType
trait AnySequencingTechnology
case object Illumina extends AnySequencingTechnology

sealed trait AnyIlluminaMachine
case object MiSeq      extends AnyIlluminaMachine
case object MiSeqDx    extends AnyIlluminaMachine
case object MiSeqFGx   extends AnyIlluminaMachine
case object NextSeq500 extends AnyIlluminaMachine
case object HiSeq2500  extends AnyIlluminaMachine
case object HiSeq3000  extends AnyIlluminaMachine
case object HiSeq4000  extends AnyIlluminaMachine
case object HiSeqXFive extends AnyIlluminaMachine
case object HiSeqXTen  extends AnyIlluminaMachine

// useless as of now
trait AnySequencingRun {

  type Technology <: AnySequencingTechnology
  val technology: Technology
  // TODO provider, whatever
}
