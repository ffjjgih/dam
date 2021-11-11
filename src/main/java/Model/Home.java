package Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the home database table.
 * 
 */
@Entity
@Table(name="home")
@NamedQuery(name="Home.findAll", query="SELECT h FROM Home h")
public class Home implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idhome;

	private String banner;

	private String link;

	private String poster;

	@Column(name="summary_content")
	private String summaryContent;

	private String title;

	public Home() {
	}

	public int getIdhome() {
		return this.idhome;
	}

	public void setIdhome(int idhome) {
		this.idhome = idhome;
	}

	public String getBanner() {
		return this.banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getSummaryContent() {
		return this.summaryContent;
	}

	public void setSummaryContent(String summaryContent) {
		this.summaryContent = summaryContent;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}