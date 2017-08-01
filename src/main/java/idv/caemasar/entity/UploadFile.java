package idv.caemasar.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_UPLOADFILE", schema = "POR")
public class UploadFile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6379961825366772510L;
	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "T_UPLOADFILE_SEQUENCE_UP_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	private int up_id;
	private String up_filename;
	private String up_filepath;
	private Date up_uploadtime;

	public UploadFile() {
	}

	public UploadFile(String up_filename, String up_filepath, Date up_uploadtime) {
		super();
		this.up_filename = up_filename;
		this.up_filepath = up_filepath;
		this.up_uploadtime = up_uploadtime;
	}

	public UploadFile(int up_id, String up_filename, String up_filepath, Date up_uploadtime) {
		this.up_id = up_id;
		this.up_filename = up_filename;
		this.up_filepath = up_filepath;
		this.up_uploadtime = up_uploadtime;
	}

	public int getUp_id() {
		return up_id;
	}

	public void setUp_id(int up_id) {
		this.up_id = up_id;
	}

	public String getUp_filename() {
		return up_filename;
	}

	public void setUp_filename(String up_filename) {
		this.up_filename = up_filename;
	}

	public String getUp_filepath() {
		return up_filepath;
	}

	public void setUp_filepath(String up_filepath) {
		this.up_filepath = up_filepath;
	}

	public Date getUp_uploadtime() {
		return up_uploadtime;
	}

	public void setUp_uploadtime(Date up_uploadtime) {
		this.up_uploadtime = up_uploadtime;
	}

	@Override
	public String toString() {
		return "UploadFile [up_id=" + up_id + ", up_filename=" + up_filename + ", up_filepath=" + up_filepath
				+ ", up_uploadtime=" + up_uploadtime + "]";
	}

}
