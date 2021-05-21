package Models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="Market")
public final class Market {
	@Id
	@GeneratedValue
	private Integer id;
	
	
	
	private Integer cardId;
	
	private Integer userId;
	
	
	public Market() {}
	
	public Market( Integer cardId, Integer userId) {
		
		this.cardId = cardId;
		this.userId = userId;
	}
	
	
	
	public Integer getMarketId() {
		return id;
	}
	
	public void setMarketId(Integer marketId) {
		this.id = marketId;
	}
	
	public Integer getCardId() {
		return cardId;
	}
	
	public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }
	
	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
	

}
